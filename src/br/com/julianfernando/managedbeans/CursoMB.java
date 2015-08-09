package br.com.julianfernando.managedbeans;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;

import br.com.julianfernando.entities.Curso;

@ManagedBean
public class CursoMB {
	
	private Curso curso = new Curso();
	
	private List<Curso> cursosList;
	
	private String siglaDoCursoEscolhidoEstatico;
	
	private String siglaDoCursoEscolhidoDinamicoList;
	
	private String siglaDoCursoEscolhidoDinamicoMap;
	
	private List<String> diciplinasAvaliadas;
	
	private List<String> disciplinaSelecionada;
	
	private List<String> turnoAvaliados;
	
	private Set<String> turnoAvaliadosHS;
	
	private String turnoSelecionadoHS;

	private String turnoSelecionado;

	private Map<String, String> cursos = new LinkedHashMap<String, String>();
	
	private Set<Curso> selectManyCursos;
	
	private Set<Curso> selectManyCurso;
	
	private List<SelectItem> groupCurso;
	
	private String groupCursoList;
	
	private String situacaoAluno;
	
	public CursoMB() {
		super();
		this.curso.setId((long) 1000);
		
		this.preencheCursos();
	}

	private void preencheCursos() {
		this.cursos.put("Engenharia de Alimentos", "EA");
		this.cursos.put("Agronomia", "AG");
		this.cursos.put("Ciência da Computação", "CC");
		this.cursos.put("Medicina", "MD");
		this.cursos.put("Química", "QU");
		
		//
		cursosList = new ArrayList<Curso>();
		
		Curso curso_1 = new Curso();
		curso_1.setNome("Curso de Direito");
		curso_1.setSigla("CA");
		cursosList.add(curso_1);
		
		Curso curso_2 = new Curso();
		curso_2.setNome("Curso de Psicologia");
		curso_2.setSigla("CEM");
		cursosList.add(curso_2);
		
		Curso curso_3 = new Curso();
		curso_3.setNome("Curso de História");
		curso_3.setSigla("HIS");
		cursosList.add(curso_3);
		
		// disciplinas avaliadas
		this.diciplinasAvaliadas = new ArrayList<String>();
		this.diciplinasAvaliadas.add("Lógica I");
		this.diciplinasAvaliadas.add("Lógica II");
		this.diciplinasAvaliadas.add("Estruturas de Dados Avançadas");
		this.diciplinasAvaliadas.add("Estudos dos Grafos");
		
		// Checkbox
		this.turnoAvaliados = new ArrayList<String>();
		this.turnoAvaliados.add("Diurno");
		this.turnoAvaliados.add("Vespertino");
		this.turnoAvaliados.add("Noturno");
		this.turnoAvaliados.add("Inegral");
		
		this.turnoAvaliadosHS = new LinkedHashSet<String>(this.turnoAvaliados);
		
		this.selectManyCursos = new LinkedHashSet<Curso>(cursosList);
		
		groupCurso = new ArrayList<SelectItem>();
		
		SelectItemGroup grupo1 = new SelectItemGroup("Grupo Cursos de Ciências Exatas");
		grupo1.setSelectItems(new SelectItem[] {
				new SelectItem("0",this.diciplinasAvaliadas.get(0)),
				new SelectItem("1",this.diciplinasAvaliadas.get(1)),
				new SelectItem("2",this.diciplinasAvaliadas.get(2)),
				new SelectItem("3",this.diciplinasAvaliadas.get(3))
		});
		
		groupCurso.add(grupo1);
		
		SelectItemGroup grupo2 = new SelectItemGroup("Groupo Cursos de Humanas");
		grupo2.setSelectItems(new SelectItem[] {
				new SelectItem(curso_1.getSigla(),curso_1.getNome()),
				new SelectItem(curso_2.getSigla(),curso_2.getNome()),
				new SelectItem(curso_3.getSigla(),curso_3.getNome())
		});
		groupCurso.add(grupo2);
	}


	public Map<String, String> getCursos() {
		return cursos;
	}

	public void setCursos(Map<String, String> cursos) {
		this.cursos = cursos;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public String getSituacaoAluno() {
		if (this.curso.getAceito() != null && this.curso.getAceito().equals(true)) {
			this.setSituacaoAluno("Aluno aceito no curso");
		} else {
			this.setSituacaoAluno("Aluno não foi aceito no curso");
		}
		return situacaoAluno;
	}

	public void setSituacaoAluno(String situacaoAluno) {
		this.situacaoAluno = situacaoAluno;
	}

	public List<Curso> getCursosList() {
		return cursosList;
	}

	public void setCursosList(List<Curso> cursosList) {
		this.cursosList = cursosList;
	}

	public String getSiglaDoCursoEscolhidoEstatico() {
		return siglaDoCursoEscolhidoEstatico;
	}
	
	public void setSiglaDoCursoEscolhidoEstatico(String siglaDoCursoEscolhido) {
		this.siglaDoCursoEscolhidoEstatico = siglaDoCursoEscolhido;
	}
	
	public String getSiglaDoCursoEscolhidoDinamicoList() {
		return siglaDoCursoEscolhidoDinamicoList;
	}

	public void setSiglaDoCursoEscolhidoDinamicoList(String siglaDoCursoEscolhidoDinamico) {
		this.siglaDoCursoEscolhidoDinamicoList = siglaDoCursoEscolhidoDinamico;
	}

	public String getSiglaDoCursoEscolhidoDinamicoMap() {
		return siglaDoCursoEscolhidoDinamicoMap;
	}

	public void setSiglaDoCursoEscolhidoDinamicoMap(String siglaDoCursoEscolhidoDinamicoMap) {
		this.siglaDoCursoEscolhidoDinamicoMap = siglaDoCursoEscolhidoDinamicoMap;
	}
	
	public List<String> getDiciplinasAvaliadas() {
		return diciplinasAvaliadas;
	}

	public List<String> getDisciplinaSelecionada() {
		return disciplinaSelecionada;
	}

	public void setDisciplinaSelecionada(List<String> disciplinaSelecionada) {
		this.disciplinaSelecionada = disciplinaSelecionada;
	}

	public String getTurnoSelecionado() {
		return turnoSelecionado;
	}
	
	public void setTurnoSelecionado(String turnoSelecionado) {
		this.turnoSelecionado = turnoSelecionado;
	}
	
	public List<String> getTurnoAvaliados() {
		return turnoAvaliados;
	}
	
	public String getTurnoSelecionadoHS() {
		return turnoSelecionadoHS;
	}

	public void setTurnoSelecionadoHS(String turnoSelecionadoHS) {
		this.turnoSelecionadoHS = turnoSelecionadoHS;
	}

	public Set<String> getTurnoAvaliadosHS() {
		return turnoAvaliadosHS;
	}

	public Set<Curso> getSelectManyCursos() {
		return selectManyCursos;
	}

	public Set<Curso> getSelectManyCurso() {
		return selectManyCurso;
	}

	public void setSelectManyCurso(Set<Curso> selectManyCurso) {
		this.selectManyCurso = selectManyCurso;
	}

	public List<SelectItem> getGroupCurso() {
		return groupCurso;
	}

	public String getGroupCursoList() {
		return groupCursoList;
	}

	public void setGroupCursoList(String groupCursoList) {
		this.groupCursoList = groupCursoList;
	}
}
