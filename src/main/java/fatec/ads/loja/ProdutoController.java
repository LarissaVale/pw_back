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
public class ProdutoController {

    /*
        METODOS HTTP
        POST   => INSERIR
        PUT    => ALTERAR
        DELETE => APAGAR
        GET    => LER
    */

    @Autowired
    ProdutoRepository bd;

    @GetMapping("/produto/{id}")
    public Produto carregar(@PathVariable int id) {
        if (bd.existsById(id)) {
            return bd.findById(id).get();
        } else {
            return new Produto();
        }
    }

    @GetMapping("/produtos")
    public List<Produto> listar() {
        return bd.findAll();
    }

    @GetMapping("/produto/vitrine")
    public List<Produto> retornaVitrine() {
        return bd.retornaVitrine();
    }

    @GetMapping("/produto/busca/{termo}")
    public List<Produto> fazBusca(@PathVariable String termo) {
        return bd.fazBusca("%" + termo + "%");
    }

    @PostMapping("/produto")
    public String gravar(@RequestBody Produto novo) {
        bd.save(novo);
        return "Produto gravado com sucesso!";
    }

    @PutMapping("/produto")
    public String alterar(@RequestBody Produto obj) {
        if (bd.existsById(obj.getCodigo())) {
            bd.save(obj);
            return "Produto alterado com sucesso!";
        } else {
            return "Produto nao encontrado!";
        }
    }

    @DeleteMapping("/produto/{id}")
    public String remover(@PathVariable int id) {
        if (bd.existsById(id)) {
            bd.deleteById(id);
            return "Produto removido com sucesso!";
        } else {
            return "Produto nao encontrado!";
        }
    }

}