package fatec.ads.loja;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class PedidoController {

    @GetMapping("/pedido/{id}")
    public Pedido buscar(@PathVariable int id) {
        Pedido pedido = new Pedido();
        pedido.setCodigo(id);
        pedido.setData("2025-04-30");
        pedido.setStatus("Aguardando");
        pedido.setTotal(140.0);
        return pedido;
    }

    @GetMapping("/pedido/cliente/{clienteId}")
    public List<Pedido> listarPorCliente(@PathVariable int clienteId) {
        return new ArrayList<Pedido>();
    }

    @PostMapping("/pedido")
    public Retorno gravar(@RequestBody Pedido novo){
        Retorno r = new Retorno();
        r.setMensagem("Pedido registrado com sucesso");
        return r;
    }

}
