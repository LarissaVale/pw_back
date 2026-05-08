package fatec.ads.loja;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class ClienteController {

    /*
        METODOS HTTP
        POST   => INSERIR
        PUT    => ALTERAR
        DELETE => APAGAR
        GET    => LER
    */

    @Autowired
    ClienteRepository bd;

    @GetMapping("/cliente/{id}")
    public Cliente buscar(@PathVariable int id) {
        if (bd.existsById(id)) {
            return bd.findById(id).get();
        } else {
            return new Cliente();
        }
    }

    @GetMapping("/clientes")
    public List<Cliente> listar() {
        return bd.findAll();
    }

    @GetMapping("/cliente/busca/{termo}")
    public List<Cliente> fazBusca(@PathVariable String termo) {
        return bd.fazBusca("%" + termo + "%");
    }

    @PostMapping("/cliente")
    public String gravar(@RequestBody Cliente novo) {
        bd.save(novo);
        return "Cliente cadastrado com sucesso!";
    }

    @PutMapping("/cliente")
    public String alterar(@RequestBody Cliente obj) {
        if (bd.existsById(obj.getCodigo())) {
            bd.save(obj);
            return "Cliente alterado com sucesso!";
        } else {
            return "Cliente nao encontrado!";
        }
    }

    @DeleteMapping("/cliente/{id}")
    public String remover(@PathVariable int id) {
        if (bd.existsById(id)) {
            bd.deleteById(id);
            return "Cliente removido com sucesso!";
        } else {
            return "Cliente nao encontrado!";
        }
    }

}