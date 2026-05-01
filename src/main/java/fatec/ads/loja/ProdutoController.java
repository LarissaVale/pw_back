package fatec.ads.loja;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class ProdutoController {
    /*
        METODOS HTTP
        POST => INSERIR
        PUT => ALTERAR
        DELETE => APAGAR
        GET => LER
        PATCH => ALTERA SOMENTE UM ATRIBUTO
    */

    @Autowired
    Produto obj;
    @GetMapping("/produto/{id}")
    public Produto carregar(@PathVariable int id){
        //TODO Recuperar do banco de dados via ID
        obj.setCodigo(id);
        obj.setDescritivo("Furadeira Eletrica");
        obj.setKeywords("Eletrica 220v");
        obj.setNome("Furadeira");
        obj.setPromo(100);
        obj.setQuantidade(100);
        obj.setValor(140);
        return obj;
    }

    @PostMapping("/produto")
    public Retorno gravar(@RequestBody Produto novo){
        //TODO Gravar obj no banco de dados
        var r = new Retorno();
        r.setMensagem("Seu prooduto foi gravado com sucesso");
        return r;
    }

    @GetMapping("/produto/vitrine")
    public List<Produto> retornaVitrine(){
        return new ArrayList<Produto>();
    }

}
