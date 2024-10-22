package pe.edu.upeu.sysalmacenfx.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.sysalmacenfx.dto.ComboBoxOption;
import pe.edu.upeu.sysalmacenfx.modelo.Categoria;
import pe.edu.upeu.sysalmacenfx.modelo.CompraDetalle;
import pe.edu.upeu.sysalmacenfx.repositorio.CategoriaRepository;
import pe.edu.upeu.sysalmacenfx.repositorio.CompraDetalleRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompraDetalleService {

    @Autowired
    CompraDetalleRepository repo;


    //C
    public CompraDetalle save(CompraDetalle to){
        return repo.save(to);
    }

    //R
    public List<CompraDetalle> list(){
        return repo.findAll();
    }
    //U
    public CompraDetalle update (CompraDetalle to, long id) {
        CompraDetalle toe =repo.findById(id).get();
        try {
            if (toe!=null) {
                toe.setProducto(to.getProducto());

            }
            return repo.save(toe);

        }catch (Exception e){
            System.out.println("Error: "+e.getMessage());
        }
        return null;

    }
    public CompraDetalle update (CompraDetalle to){
        return repo.save(to);
    }
    //D
    public void delete (Long id){
        repo.deleteById(id);
    }

    //B
    public CompraDetalle searchById(Long id){
        return repo.findById(id).get();
    }

    public List<ComboBoxOption> listaCategoriaCombobox(){
        List<ComboBoxOption> listar=new ArrayList<>();
        ComboBoxOption cb;
        for
        (CompraDetalle cate : repo.findAll()) {
            cb=new ComboBoxOption();
            cb.setKey(String.valueOf(cate.getIdCompraDetalle()));
            cb.setValue(cate.getProducto().getNombre());
            listar.add(cb);

        }
        return listar;
    }
}
