package br.com.fiap.resource;

import br.com.fiap.bo.UsuarioBO;
import br.com.fiap.to.UsuarioTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioResource {
    private UsuarioBO usuarioBO = new UsuarioBO();

    @GetMapping //requisicao get
    public ResponseEntity<List<UsuarioTO>> findAll(){
        List<UsuarioTO> usuarios = usuarioBO.findAll();
        if(usuarios != null){
            return ResponseEntity.status(HttpStatus.OK).body(usuarios);
            //configurando o retorno com status ok 200
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(usuarios);
            //configurando o retorno com status not found 404
        }
    }

    @GetMapping("/{idUsuario}")
    public ResponseEntity<?>findByCodigo(@PathVariable Integer idUsuario){
        UsuarioTO usuario = usuarioBO.findByCodigo(idUsuario);
        if(usuario != null){
            return ResponseEntity.status(HttpStatus.OK).body(usuario);
            //configurando o retorno com status ok 200
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(usuario);
            //configurando o retorno com status not found 404
        }
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody @Valid UsuarioTO usuario){
        try {
            UsuarioTO resultado = usuarioBO.save(usuario);
            return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao salvar usuario");
        }
    }

    @DeleteMapping("/{idUsuario}")
    public ResponseEntity<String> delete(@PathVariable Integer idUsuario){
        if(usuarioBO.delete(idUsuario)){
            return  ResponseEntity.status(HttpStatus.NO_CONTENT).body("Usuario deletada com sucesso!");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario não encontrada!");
        }
    }

    @PutMapping("/{idUsuario}")
    public ResponseEntity<?> update (@PathVariable Integer idUsuario,
                                     @RequestBody @Valid UsuarioTO usuario){
        try {
            usuario.setIdUsuario(idUsuario);
            UsuarioTO resultado = usuarioBO.update(usuario);
            return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Erro ao atualizar o usuario");
        }
    }

}
