package pe.edu.upeu.sysalmacenfx.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.sysalmacenfx.dto.ComboBoxOption;
import pe.edu.upeu.sysalmacenfx.modelo.Emisor;
import pe.edu.upeu.sysalmacenfx.repositorio.EmisorRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmisorService {

    @Autowired
    EmisorRepository repo;


    //C
    public Emisor save(Emisor to){
        return repo.save(to);
    }

    //R
    public List<Emisor> list(){
        return repo.findAll();
    }
    //U
    public Emisor update (Emisor to, long id) {
        Emisor toe =repo.findById(id).get();
        try {
            if (toe!=null) {
                toe.setNombreComercial(to.getNombreComercial());

            }
            return repo.save(toe);

        }catch (Exception e){
            System.out.println("Error: "+e.getMessage());
        }
        return null;

    }
    public Emisor update (Emisor to){
        return repo.save(to);
    }
    //D
    public void delete (Long id){
        repo.deleteById(id);
    }

    //B
    public Emisor searchById(Long id){
        return repo.findById(id).get();
    }

    public List<ComboBoxOption> listaCategoriaCombobox(){
        List<ComboBoxOption> listar=new ArrayList<>();
        ComboBoxOption cb;
        for
        (Emisor cate : repo.findAll()) {
            cb=new ComboBoxOption();
            cb.setKey(String.valueOf(cate.getIdEmisor()));
            cb.setValue(cate.getNombreComercial());
            listar.add(cb);

        }
        return listar;
    }
}
