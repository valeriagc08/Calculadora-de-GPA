import java.util.List;

class Materia {
    private String codigo;
    private int creditos;
    private char nota;
    
    public Materia(String codigo, int creditos, char nota) {
        setCodigo(codigo);
        setCreditos(creditos);
        setNota(nota);
    }
    
    public String getCodigo() {
        return codigo;
    }
    
	public void setCodigo(String codigo) {
	    // Validar que el código tenga 6 dígitos y no inicie con dos ceros
	    if (codigo.length() == 4) {
	        this.codigo = codigo;
	    } else {
	        throw new IllegalArgumentException("Código de estudiante inválido. Debe tener 6 dígitos y no comenzar con dos ceros.");
	    }
	}
    
    public int getCreditos() {
        return creditos;
    }
    
	public void setCreditos(int creditos) {
	    // Validar que el número de créditos sea 0, 1, 2, 3, 4 o 5
	    if (creditos >= 0 && creditos <= 5) {
	        this.creditos = creditos;
	    } else {
	        throw new IllegalArgumentException("Número de créditos inválido. Debe ser 0, 1, 2, 3, 4 o 5.");
	    }
	}

    
    public char getNota() {
        return nota;
    }
    
	public void setNota(char nota) {
	    // Validar que la nota sea un único carácter y sea A, B, C, D, F o P
	    if (Character.isLetter(nota) && (nota == 'A' || nota == 'B' || nota == 'C' || nota == 'D' || nota == 'F' || nota == 'P')) {
	        this.nota = nota;
	    } else {
	        throw new IllegalArgumentException("Nota inválida. Debe ser un único carácter y ser A, B, C, D, F o P.");
	    }
	}

    
    @Override
    public String toString() {
        return "Materia [codigo=" + codigo + ", Creditos=" + creditos + ", nota=" + nota + "]";
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Materia other = (Materia) obj;
        return codigo.equals(other.codigo) && creditos == other.creditos && nota == other.nota;
    }
    
    @Override
    public int compareTo(Materia other) {
        return codigo.compareTo(other.codigo);
    }
}

class Estudiante implements Comparable<Estudiante> {
    private String codigo;
    private String nombre;
    private String apellido;
    private List<Materia> transcript;
    
    public Estudiante(String codigo, String nombre, String apellido, List<Materia> transcript) {
        setCodigo(codigo);
        setNombre(nombre);
        setApellido(apellido);
        setTranscript(transcript);
    }
    
    public String getCodigo() {
        return codigo;
    }
    
	public void setCodigo(String codigo) {
    // Validar que el código tenga 6 dígitos y no inicie con dos ceros
    if (codigo.length() == 6 && !codigo.startsWith("00")) {
        this.codigo = codigo;
    } else {
        throw new IllegalArgumentException("Código de estudiante inválido. Debe tener 6 dígitos y no comenzar con dos ceros.");
    }
}
    
    public String getNombre() {
        return nombre;
    }
    
	public void setNombre(String nombre) {
	    // Validar que el nombre no sea nulo ni esté vacío
	    if (nombre != null && !nombre.isEmpty()) {
	        this.nombre = nombre;
	    } else {
	        throw new IllegalArgumentException("Nombre inválido. No puede ser nulo ni estar vacío.");
	    }
	}
    
    public String getApellido() {
        return apellido;
    }
    
	public void setApellido(String apellido) {
	    // Validar que el apellido no sea nulo ni esté vacío
	    if (apellido != null && !apellido.isEmpty()) {
	        this.apellido = apellido;
	    } else {
	        throw new IllegalArgumentException("Apellido inválido. No puede ser nulo ni estar vacío.");
	    }
	}

    
    public List<Materia> getTranscript() {
        return transcript;
    }
    
	public void setTranscript(List<Materia> transcript) {
	    // Validar que haya exactamente 5 materias en el transcript
	    if (transcript != null && transcript.size() == 5) {
	        this.transcript = transcript;
	    } else {
	        throw new IllegalArgumentException("Transcript inválido. Debe contener exactamente 5 materias.");
	    }
	}
    
    @Override
    public String toString() {
        return "Estudiante [codigo=" + codigo + ", nombre=" + nombre + ", apellido=" + apellido + ", transcript=" + transcript + "]";
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Estudiante other = (Estudiante) obj;
        return codigo.equals(other.codigo) && nombre.equals(other.nombre) && apellido.equals(other.apellido)
                && transcript.equals(other.transcript);
    }
    
    @Override
    public int compareTo(Estudiante other) {
        return codigo.compareTo(other.codigo);
    }
}


