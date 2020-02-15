package com.project.controllers;

import com.project.db.DBConnection;
import com.project.db.Hotels;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class HomeController {

    @Autowired
    private DBConnection connection;

    @GetMapping(path = "/")
    public String index(Model model){

        ArrayList<Hotels> hotels = connection.getAllHotels();
        model.addAttribute("hotels", hotels);

        return "index";
    }

    @GetMapping(path = "/addhotel")
    public String addHotel(Model model){

        return "addhotel";

    }

    @PostMapping(path = "/addhotel")
    public String toAddHotel(@RequestParam("name") String name,
                            @RequestParam("country") String country,
                            @RequestParam("stars") int stars){

        Hotels h = new Hotels(null, name, country, stars);

        if(connection.addHotel(h)){
            return "redirect:addhotel?success";
        }else{
            return "redirect:addhotel?error";
        }

    }

    @GetMapping(path = "/edithotel/{id}")
    public String editHotel(Model model, @PathVariable("id") Long id){

        Hotels hotels = connection.getHotel(id);
        model.addAttribute("hotels", hotels);

        return "edithotel";

    }

    @PostMapping(path = "/edithotel")
    public String toEditHotel(@RequestParam("id") Long id,
                              @RequestParam("name") String name,
                             @RequestParam("country") String country,
                             @RequestParam("stars") int stars){

        Hotels h = new Hotels(id, name, country, stars);

        if(connection.editHotel(h)){
            return "redirect:readhotel?success";
        }else{
            return "redirect:readhotel?error";
        }

    }

    @GetMapping(path = "/readhotel/{id}")
    public String readHotel(Model model, @PathVariable("id") Long id ){

        Hotels hotel = connection.getHotel(id);
        model.addAttribute("hotel", hotel);

        return "readhotel";
    }
}
