package pe.edu.upeu.sysalmacenfx.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.sysalmacenfx.dto.ComboBoxOption;
import pe.edu.upeu.sysalmacenfx.modelo.Perfil;
import pe.edu.upeu.sysalmacenfx.repositorio.PerfilRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class PerfilService {

    @Autowired
    PerfilRepository repo;


    //C
    public Perfil save(Perfil to){
        return repo.save(to);
    }

    //R
    public List<Perfil> list(){
        return repo.findAll();
    }
    //U
    public Perfil update (Perfil to, long id) {
        Perfil toe =repo.findById(id).get();
        try {
            if (toe!=null) {
                toe.setNombre(to.getNombre());

            }
            return repo.save(toe);

        }catch (Exception e){
            System.out.println("Error: "+e.getMessage());
        }
        return null;

    }
    public Perfil update (Perfil to){
        return repo.save(to);
    }
    //D
    public void delete (Long id){
        repo.deleteById(id);
    }

    //B
    public Perfil searchById(Long id){
        return repo.findById(id).get();
    }

    public List<ComboBoxOption> listaCategoriaCombobox(){
        List<ComboBoxOption> listar=new ArrayList<>();
        ComboBoxOption cb;
        for
        (Perfil cate : repo.findAll()) {
            cb=new ComboBoxOption();
            cb.setKey(String.valueOf(cate.getIdPerfil()));
            cb.setValue(cate.getNombre());
            listar.add(cb);

        }
        return listar;
    }
}
