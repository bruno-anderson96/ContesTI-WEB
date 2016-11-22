var Brewer = Brewer || {};

Brewer.ComboDisciplina = (function(){
	
	function ComboDisciplina(){
		this.combo = $('#idDisciplina');
		this.emitter = $({});
		this.on = this.emitter.on.bind(this.emitter);
	}
	ComboDisciplina.prototype.iniciar=function(){
		this.combo.on('change', onDisciplinaAlterada.bind(this));
	}
	
	function onDisciplinaAlterada(){
		console.log('Disciplina alterada', this.combo.val());
		this.emitter.trigger('alterado', this.combo.val());
	}
	
	
	return ComboDisciplina;
	
	
}());

Brewer.ComboAssunto = (function(){
	
	function ComboAssunto(comboDisciplina){
		this.comboDisciplina = comboDisciplina;
		this.combo = $('#idAssunto');
	}
	ComboAssunto.prototype.iniciar=function(){
		reset.call(this);
		this.comboDisciplina.on('alterado', onDisciplinaAlterada.bind(this));
		
	}
	
	function onDisciplinaAlterada(evento, codigoDisciplina){
		
		console.log('codigo da disciplina no combo assunto', codigoDisciplina);
		if(codigoDisciplina){
		var response = $.ajax({
			url: this.combo.data('url'),
			method: 'GET',
			contentType:'application/json',
			data: {'disciplina': codigoDisciplina}
		
		
			
		});
		response.done(onBuscarAssuntosFinalizado.bind(this));
	}else{
		reset.call(this);		
	}		
}
	
	function onBuscarAssuntosFinalizado(assuntos){
		var options = [];
		assuntos.forEach(function(assunto){
			options.push('<option value"' + assunto.id + '">'+assunto.descricao+'</option>');
		});
		this.combo.html(options.join(''));
		this.combo.removeAttr('disabled');
	}
	function reset(){
		this.combo.html('<option value="">Assunto</option>');
		this.combo.val('');
		this.combo.attr('disabled','disabled');
	}
	
	
	
	
	return ComboAssunto;
}());


window.onload = function(){
	
	var comboDisciplina = new Brewer.ComboDisciplina();
	comboDisciplina.iniciar();
	
	var comboAssunto = new Brewer.ComboAssunto(comboDisciplina);
	comboAssunto.iniciar();
	
};