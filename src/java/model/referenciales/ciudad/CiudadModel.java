package model.referenciales.ciudad;

/**
 *
 * @author juan
 */
public class CiudadModel {
    private Integer id;
    private String descripcion;

    public CiudadModel() {
    }

    public CiudadModel(Integer id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "CiudadModel{" + "id=" + id + ", descripcion=" + descripcion + '}';
    }
}
