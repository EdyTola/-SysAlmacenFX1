package pe.edu.upeu.sysalmacenfx.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.sysalmacenfx.dto.ComboBoxOption;
import pe.edu.upeu.sysalmacenfx.modelo.Categoria;
import pe.edu.upeu.sysalmacenfx.modelo.VentaDetalle;
import pe.edu.upeu.sysalmacenfx.repositorio.CategoriaRepository;
import pe.edu.upeu.sysalmacenfx.repositorio.VentaDetalleRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class VentaDetalleService {

    @Autowired
    VentaDetalleRepository repo;


    //C
    public VentaDetalle save(VentaDetalle to){
        return repo.save(to);
    }

    //R
    public List<VentaDetalle> list(){
        return repo.findAll();
    }
    //U
    public VentaDetalle update (VentaDetalle to, long id) {
        VentaDetalle toe =repo.findById(id).get();
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
    public VentaDetalle update (VentaDetalle to){
        return repo.save(to);
    }
    //D
    public void delete (Long id){
        repo.deleteById(id);
    }

    //B
    public VentaDetalle searchById(Long id){
        return repo.findById(id).get();
    }

    public List<ComboBoxOption> listaCategoriaCombobox(){
        List<ComboBoxOption> listar=new ArrayList<>();
        ComboBoxOption cb;
        for
        (VentaDetalle cate : repo.findAll()) {
            cb=new ComboBoxOption();
            cb.setKey(String.valueOf(cate.getIdVentaDetalle()));
            cb.setValue(cate.getProducto().getNombre());
            listar.add(cb);

        }
        return listar;
    }
}
