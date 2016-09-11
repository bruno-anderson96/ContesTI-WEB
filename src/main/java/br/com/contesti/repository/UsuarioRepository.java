  package br.com.contesti.repository;
   
  import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.com.contesti.entidades.Usuario;
   
  @RepositoryRestResource(collectionResourceRel = "usuario", path = "usuarios")
  public interface UsuarioRepository extends PagingAndSortingRepository<Usuario, Long> {
        
        /**
         * Método que retorna uma lista de clientes fazendo a busca pelo nome passado como parâmetro.
         *  
         * @param name
         * @return lista de clientes
         *
         * */
	
      
        
        
        /**
         * Método que retorna o cliente com apenas seu nome fazendo a busca com o id passado como parâmetro.
         * 
         * @param id
         * @return cliente do id passado como parâmetro.
         */   
        @Query("SELECT u.nome_usuario FROM Usuario u where u.id = :id")
        List<Usuario> findById(@Param("nome_usuario") String id);
        Usuario findNomeById(@Param("idUsuario") Long id);

        /**
         * Método que retorna uma lista de clientes fazendo a busca pelo nome passado como parâmetro e ordenando os 
         * clientes pelo nome.
         *  
         * @param name
         * @return lista de clientes
         
        List<Usuario> findByNomeOrderByNome(@Param("nome_usuario") String name);
   */
  }