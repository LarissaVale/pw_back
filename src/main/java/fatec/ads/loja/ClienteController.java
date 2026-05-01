package fatec.ads.loja;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class ClienteController {

    @GetMapping("/cliente/{id}")
    public Cliente buscar(@PathVariable int id) {
        //TODO: buscar do banco pelo id
        Cliente cliente = new Cliente();
        cliente.setCodigo(id);
        cliente.setNome("João Silva");
        cliente.setCpf("123.456.789-00");
        cliente.setEmail("joao@email.com");
        cliente.setTelefone("(11) 91234-5678");
        return cliente;
    }

    @GetMapping("/cliente")
    public List<Cliente> listar() {
        //TODO: buscar lista real no banco
        return new ArrayList<Cliente>();
    }

    @PostMapping("/cliente")
    public Retorno gravar(@RequestBody Cliente novo){
        Retorno r = new Retorno();
        r.setMensagem("Cliente cadastrado com sucesso");
        return r;
    }

}
