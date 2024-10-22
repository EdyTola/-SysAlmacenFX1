package pe.edu.upeu.sysalmacenfx.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.sysalmacenfx.dto.ComboBoxOption;
import pe.edu.upeu.sysalmacenfx.modelo.Cliente;
import pe.edu.upeu.sysalmacenfx.repositorio.ClienteRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository repo;


    //C
    public Cliente save(Cliente to){
        return repo.save(to);
    }

    //R
    public List<Cliente> list(){
        return repo.findAll();
    }
    //U
    public Cliente update (Cliente to, long id) {
        Cliente toe =repo.findById(id).get();
        try {
            if (toe!=null) {
                toe.setNombres(to.getNombres());

            }
            return repo.save(toe);

        }catch (Exception e){
            System.out.println("Error: "+e.getMessage());
        }
        return null;

    }
    public Cliente update (Cliente to){
        return repo.save(to);
    }
    //D
    public void delete (Long id){
        repo.deleteById(id);
    }

    //B
    public Cliente searchById(Long id){
        return repo.findById(id).get();
    }

    public List<ComboBoxOption> listaCategoriaCombobox(){
        List<ComboBoxOption> listar=new ArrayList<>();
        ComboBoxOption cb;
        for
        (Cliente cate : repo.findAll()) {
            cb=new ComboBoxOption();
            cb.setKey(String.valueOf(cate.getNombres()));
            cb.setValue(cate.getNombres());
            listar.add(cb);

        }
        return listar;
    }
}
