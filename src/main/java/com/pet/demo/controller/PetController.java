package com.pet.demo.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
//import com.pet.demo.config.Log;
import com.pet.demo.entity.Pet;
import com.pet.demo.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/PetTest")
public class PetController {
    @Autowired
    private PetService petService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping("/pet")
    public String findAll(Model model, @RequestParam(defaultValue = "1") Integer pageNum,
                          @RequestParam(name = "searchName", required = false) String searchName){
//        model.addAttribute("url", "/PetTest/pet");
        if(StringUtils.isEmpty(searchName)){
            PageHelper.startPage(pageNum,5);

//            String pets1 = stringRedisTemplate.opsForValue().get("pets");
//            System.out.println(pets1);

//            if (StrUtil.isNotBlank(pets1)){
//                List<Pet> petsList = JSONUtil.toList(pets1, Pet.class);
//                PageInfo<Pet> pageInfo = new PageInfo<>(petsList);
//                model.addAttribute("pagelist",pageInfo);
//                return "pet";
//            }else {
                List<Pet> pets=petService.findAll();
//                stringRedisTemplate.opsForValue().set("pets", JSONUtil.toJsonStr(pets),5, TimeUnit.MINUTES);
                PageInfo<Pet> pageInfo = new PageInfo<>(pets);
                model.addAttribute("pagelist",pageInfo);
                return "pet_b";
//            }
        }
        else {
            String name='%'+searchName+'%';
            PageHelper.startPage(pageNum,5);
            List<Pet> pets=petService.findByName(name);
            PageInfo<Pet> pageInfo = new PageInfo<>(pets);
            model.addAttribute("pagelist",pageInfo);
            return "pet_b";
        }

    }

    @PostMapping("/save")
    public String savePet(@RequestParam(value = "petPic") MultipartFile file,HttpServletRequest request){
//       本地图片上传

        String originalFilename = file.getOriginalFilename();//abc.jpg
        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));

        //使用UUID重新生成文件名，防止文件名称重复造成文件覆盖
        String fileName = UUID.randomUUID().toString() + suffix;//dfsdfdfd.jpg
        System.out.println(fileName);
        //创建一个目录对象
        java.io.File dir = new java.io.File("D:\\project\\SpringBoot\\demo\\src\\main\\resources\\static\\img");
        //判断当前目录是否存在
        if(!dir.exists()){
            //目录不存在，需要创建
            dir.mkdirs();
        }
        try {
            //将临时文件转存到指定位置
            file.transferTo(new java.io.File("D:\\project\\SpringBoot\\demo\\src\\main\\resources\\static\\img\\" + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Pet pet = new Pet();
        pet.setPetName(request.getParameter("petName"));
        pet.setPetDetail(request.getParameter("petDetail"));
        pet.setPetSex(request.getParameter("petSex"));
        pet.setPetState(request.getParameter("petState"));
        pet.setPetSub(request.getParameter("petSub"));
        pet.setPetType(request.getParameter("petType"));
        pet.setPetBir(request.getParameter("petBir"));
        pet.setPetPic(fileName);

        //判断进行添加还是修改操作

        if(StringUtils.isEmpty(request.getParameter("petId"))){
            petService.save(pet);
        }else {
            pet.setPetId(request.getParameter("petId"));
            petService.update(pet);
        }



        return "redirect:/PetTest/pet";
    }


    @GetMapping("/delete")
    public String deletePet(String petId){
        petService.delete(petId);
        return "redirect:/PetTest/pet";
    }


    @GetMapping("/findByName")
    public String findByName(Model model,@RequestParam(name = "searchName",required = false) String searchName){
        String name='%'+searchName+'%';
        List<Pet> pets=petService.findByName(name);
        model.addAttribute("pets",pets);
        return "pet_b";
    }
}
