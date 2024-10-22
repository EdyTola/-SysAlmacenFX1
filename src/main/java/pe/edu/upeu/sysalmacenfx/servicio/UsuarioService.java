package pe.edu.upeu.sysalmacenfx.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.sysalmacenfx.dto.ComboBoxOption;
import pe.edu.upeu.sysalmacenfx.modelo.Categoria;
import pe.edu.upeu.sysalmacenfx.modelo.Usuario;
import pe.edu.upeu.sysalmacenfx.repositorio.UsuarioRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository repo;


    //C
    public Usuario save(Usuario to){
        return repo.save(to);
    }

    //R
    public List<Usuario> list(){
        return repo.findAll();
    }
    //U
    public Usuario update (Usuario to, long id) {
        Usuario toe =repo.findById(id).get();
        try {
            if (toe!=null) {
                toe.setUser(to.getUser());

            }
            return repo.save(toe);

        }catch (Exception e){
            System.out.println("Error: "+e.getMessage());
        }
        return null;

    }
    public Usuario update (Usuario to){
        return repo.save(to);
    }
    //D
    public void delete (Long id){
        repo.deleteById(id);
    }

    //B
    public Usuario searchById(Long id){
        return repo.findById(id).get();
    }

    public List<ComboBoxOption> listaCombobox(){
        List<ComboBoxOption> listar=new ArrayList<>();
        ComboBoxOption cb;
        for
        (Usuario cate : repo.findAll()) {
            cb=new ComboBoxOption();
            cb.setKey(String.valueOf(cate.getIdUsuario()));
            cb.setValue(cate.getUser());
            listar.add(cb);

        }
        return listar;
    }
}
