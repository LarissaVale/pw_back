package fatec.ads.loja;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository
        extends JpaRepository<Produto, Integer> {

    @Query(value = "select * from produto where destaque>0 order by destaque", nativeQuery=true)
    public List<Produto> retornaVitrine();

    @Query(value= "select * from produto where nome like ? ", nativeQuery = true)
    public List<Produto> fazBusca(String termo);

}
