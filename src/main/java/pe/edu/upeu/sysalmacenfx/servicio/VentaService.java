package pe.edu.upeu.sysalmacenfx.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.sysalmacenfx.dto.ComboBoxOption;
import pe.edu.upeu.sysalmacenfx.modelo.Categoria;
import pe.edu.upeu.sysalmacenfx.modelo.Venta;
import pe.edu.upeu.sysalmacenfx.repositorio.CategoriaRepository;
import pe.edu.upeu.sysalmacenfx.repositorio.VentaRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class VentaService {

    @Autowired
    VentaRepository repo;


    //C
    public Venta save(Venta to){
        return repo.save(to);
    }

    //R
    public List<Venta> list(){
        return repo.findAll();
    }
    //U
    public Venta update (Venta to, long id) {
        Venta toe =repo.findById(id).get();
        try {
            if (toe!=null) {
                toe.setVentaDetalles(to.getVentaDetalles());

            }
            return repo.save(toe);

        }catch (Exception e){
            System.out.println("Error: "+e.getMessage());
        }
        return null;

    }
    public Venta update (Venta to){
        return repo.save(to);
    }
    //D
    public void delete (Long id){
        repo.deleteById(id);
    }

    //B
    public Venta searchById(Long id){
        return repo.findById(id).get();
    }

    public List<ComboBoxOption> listaCategoriaCombobox(){
        List<ComboBoxOption> listar=new ArrayList<>();
        ComboBoxOption cb;
        for
        (Venta cate : repo.findAll()) {
            cb=new ComboBoxOption();
            cb.setKey(String.valueOf(cate.getIdVenta()));
            cb.setValue(cate.getCliente().getNombres());
            listar.add(cb);

        }
        return listar;
    }
}
