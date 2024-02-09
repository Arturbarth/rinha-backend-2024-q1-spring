package br.com.arturbarth.rinhabackend.repository;

import br.com.arturbarth.rinhabackend.entity.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TransacaoRepository extends JpaRepository<Transacao, Integer> {

    @Query(value = "SELECT t.* FROM TRANSACAO t WHERE t.CLIENTE_ID = :id order by t.data desc limit 10", nativeQuery = true)
    List<Transacao> findTransacaoByClienteId(Integer id);

}
