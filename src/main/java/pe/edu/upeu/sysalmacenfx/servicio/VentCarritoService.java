package pe.edu.upeu.sysalmacenfx.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.sysalmacenfx.dto.ComboBoxOption;
import pe.edu.upeu.sysalmacenfx.modelo.Categoria;
import pe.edu.upeu.sysalmacenfx.modelo.VentCarrito;
import pe.edu.upeu.sysalmacenfx.repositorio.VentCarritoRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class VentCarritoService {

    @Autowired
    VentCarritoRepository repo;


    //C
    public VentCarrito save(VentCarrito to){
        return repo.save(to);
    }

    //R
    public List<VentCarrito> list(){
        return repo.findAll();
    }
    //U
    public VentCarrito update (VentCarrito to, long id) {
        VentCarrito toe =repo.findById(id).get();
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
    public VentCarrito update (VentCarrito to){
        return repo.save(to);
    }
    //D
    public void delete (Long id){
        repo.deleteById(id);
    }

    //B
    public VentCarrito searchById(Long id){
        return repo.findById(id).get();
    }

    public List<ComboBoxOption> listaCategoriaCombobox(){
        List<ComboBoxOption> listar=new ArrayList<>();
        ComboBoxOption cb;
        for
        (VentCarrito cate : repo.findAll()) {
            cb=new ComboBoxOption();
            cb.setKey(String.valueOf(cate.getIdCarrito()));
            cb.setValue(cate.getNombreProducto());
            listar.add(cb);

        }
        return listar;
    }
}
