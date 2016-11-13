package br.com.contesti.controller;

import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.contesti.entidades.Disciplina;
import br.com.contesti.entidades.Role;
import br.com.contesti.entidades.Usuario;
import br.com.contesti.repository.RoleRepository;
import br.com.contesti.repository.UsuarioRepository;

@Controller
@RequestMapping("/cadastro")
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private RoleRepository roleRepository;

	Md5PasswordEncoder encoder = new Md5PasswordEncoder();

	@RequestMapping(value = "/AdicionarPermissao", method = RequestMethod.POST)
	@ResponseBody
	@Transactional
	public ModelAndView adicionarPermissao(RedirectAttributes attributes, @Valid Disciplina disciplina,
			BindingResult result,@RequestParam String role,@RequestParam Usuario usuario) {
		ModelAndView mv = new ModelAndView("redirect:/homeAdm");
		Role rr = roleRepository.findByRole(role);
		usuario = usuarioRepository.findOne(usuario.getIdUsuario());
		usuarioRepository.save(usuario).setRoles(Arrays.asList(rr));
		attributes.addFlashAttribute("mensagem", "Permissão adicionada");
		return mv;
	}

	@RequestMapping(value = "/criarUsuario", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView create(@RequestParam String nome_usuario, @RequestParam String login,
			@RequestParam String senha, @RequestParam String email, @RequestParam String confirmar_senha, Boolean ativo,
			Model model, RedirectAttributes attributes, @Valid Usuario usuario, BindingResult result) throws Exception {

		List<Usuario> u = usuarioRepository.findByLogin(login);
		ModelAndView mv = new ModelAndView("redirect:/cadastro");
		if (u.size() != 0) {
			attributes.addFlashAttribute("erro", "Usuário já existe");
			return mv;

		} else if (result.hasFieldErrors("login")) {
			attributes.addFlashAttribute("erro", "Login deve conter ao menos 5 caracteres");
			return mv;
		} else if (result.hasFieldErrors("nome_usuario")) {
			attributes.addFlashAttribute("erro", "Preencha seu nome");
			return mv;
		}
		if (!usuario.isEmailValid(email)) {
			attributes.addFlashAttribute("erro", "Email inválido");
			return mv;
		} else {
			if (result.hasFieldErrors("senha")) {
				attributes.addFlashAttribute("erro", "Senha deve conter ao menos 8 caracteres");
				return mv;
			} else {
				if (senha.equals(confirmar_senha)) {
					senha = encoder.encodePassword(senha, null);
					Role roleUser = roleRepository.findByRole("USUARIO");
					usuario.setRoles(Arrays.asList(roleUser));
					usuarioRepository.save(new Usuario(nome_usuario, login, senha, email, roleUser));
					attributes.addFlashAttribute("mensagem", "Usuário criado com sucesso!");
					return mv;
				} else {
					attributes.addFlashAttribute("erro", "Senhas diferentes");
					return mv;
				}

			}
		}

	}
}

