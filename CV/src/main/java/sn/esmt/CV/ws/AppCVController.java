package sn.esmt.CV.ws;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sn.esmt.CV.entities.AppCVEntity;
import sn.esmt.CV.dao.AppCVRepository;

import java.util.List;

@RestController
@RequestMapping(value = "/usersCV")
@AllArgsConstructor
public class AppCVController {
    private AppCVRepository appCVRepository;

    //Fonction qui insere dans la Base de Donee
    @PostMapping(path = "/save")//POST REQUEST
    public AppCVEntity save(@RequestBody AppCVEntity appCVEntity){
        return appCVRepository.save(appCVEntity);
    }


    //Fonction qui retourne la liste des cv
    @GetMapping(path = "/all")
    public List<AppCVEntity> getAll(){
        return appCVRepository.findAll();
    }


    //Recupere toutes les informations sur un seul CV
    @GetMapping(path = "/getCV")//GET REQUEST
    public AppCVEntity login(@RequestParam int id){
        return appCVRepository.findById(id);
    }



}
