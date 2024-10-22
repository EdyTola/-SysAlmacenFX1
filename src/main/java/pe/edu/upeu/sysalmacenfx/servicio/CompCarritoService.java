package pe.edu.upeu.sysalmacenfx.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.sysalmacenfx.dto.ComboBoxOption;
import pe.edu.upeu.sysalmacenfx.modelo.Categoria;
import pe.edu.upeu.sysalmacenfx.modelo.CompCarrito;
import pe.edu.upeu.sysalmacenfx.repositorio.CategoriaRepository;
import pe.edu.upeu.sysalmacenfx.repositorio.CompCarritoRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompCarritoService {

    @Autowired
    CompCarritoRepository repo;

    //C
    public CompCarrito save(CompCarrito to){
        return repo.save(to);
    }

    //R
    public List<CompCarrito> list(){
        return repo.findAll();
    }
    //U
    public CompCarrito update (CompCarrito to, long id) {
        CompCarrito toe =repo.findById(id).get();
        try {
            if (toe!=null) {
                toe.setNombreProducto(to.getNombreProducto());

            }
            return repo.save(toe);

        }catch (Exception e){
            System.out.println("Error: "+e.getMessage());
        }
        return null;

    }
    public CompCarrito update (CompCarrito to){
        return repo.save(to);
    }
    //D
    public void delete (Long id){
        repo.deleteById(id);
    }

    //B
    public CompCarrito searchById(Long id){
        return repo.findById(id).get();
    }

    public List<ComboBoxOption> listaCategoriaCombobox(){
        List<ComboBoxOption> listar=new ArrayList<>();
        ComboBoxOption cb;
        for
        (CompCarrito cate : repo.findAll()) {
            cb=new ComboBoxOption();
            cb.setKey(String.valueOf(cate.getIdCompCarrito()));
            cb.setValue(cate.getNombreProducto());
            listar.add(cb);

        }
        return listar;
    }
}
