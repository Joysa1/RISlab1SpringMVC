package com.example.lab1.Controller;

import com.example.lab1.Docs.Apartaments;
import com.example.lab1.Repos.ApartamentsRepository;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Controller
public class MainController {
    final
    ApartamentsRepository apartamentsRepository;

    public MainController(ApartamentsRepository apartamentsRepository) {
        this.apartamentsRepository = apartamentsRepository;
    }

    @GetMapping("/home")
    public String home(Model model)
    {
        List<Apartaments> apartaments = apartamentsRepository.findAll();
        model.addAttribute("apartaments", apartaments);
        return "home";
    }
    @GetMapping("/new")
    public String kek(Model model){
        return "newApartament";
    }
    @PostMapping("/new")
    public String addNewApartament(@ModelAttribute Apartaments apartament, Model model)
    {
        apartamentsRepository.save(apartament);
        List<Apartaments> apartaments = apartamentsRepository.findAll();
        model.addAttribute("apartaments", apartaments);
        return "home";
    }
    @GetMapping("/apartament/{id}")
    public String apartament(Model model, @PathVariable String id)
    {
        Apartaments apartaments = apartamentsRepository.findBy_Id(id);
        model.addAttribute("apartament", apartaments);
        apartaments.incrementCounter();
        apartamentsRepository.save(apartaments);
        return "apartament";
    }
    @PostMapping ("/apartament/{id}")
    String saveApartaments(@ModelAttribute("filename") String filename, Model model, @PathVariable String id)
    {
        Apartaments apartament = apartamentsRepository.findBy_Id(id);
        try(FileWriter writer = new FileWriter(filename + ".txt", false))
        {
            // запись всей строки
            writer.write(apartament.toString());
            // запись по символам
            writer.append('\n');
            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
        List<Apartaments> apartaments = apartamentsRepository.findAll();
        model.addAttribute("apartaments", apartaments);
        return "home";
    }
}