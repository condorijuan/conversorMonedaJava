public class EntidadConversor {

    private String ultima_actualizacion;
    private String siguiente_actualizacion;
    private String codigo_origen;
    private String codigo_destino;
    private String ratio_conversion;
    private String resultado_conversion;

    public EntidadConversor(ConversorExchager c) {
        this.ultima_actualizacion = c.time_last_update_utc();
        this.siguiente_actualizacion = c.time_next_update_utc();
        this.codigo_origen = c.base_code();
        this.codigo_destino = c.target_code();
        this.ratio_conversion = c.conversion_rate();
        this.resultado_conversion = c.conversion_result();
    }

    public String getUltima_actualizacion() {
        return ultima_actualizacion;
    }

    public void setUltima_actualizacion(String ultima_actualizacion) {
        this.ultima_actualizacion = ultima_actualizacion;
    }

    public String getSiguiente_actualizacion() {
        return siguiente_actualizacion;
    }

    public void setSiguiente_actualizacion(String siguiente_actualizacion) {
        this.siguiente_actualizacion = siguiente_actualizacion;
    }

    public String getCodigo_origen() {
        return codigo_origen;
    }

    public void setCodigo_origen(String codigo_origen) {
        this.codigo_origen = codigo_origen;
    }

    public String getCodigo_destino() {
        return codigo_destino;
    }

    public void setCodigo_destino(String codigo_destino) {
        this.codigo_destino = codigo_destino;
    }

    public String getRatio_conversion() {
        return ratio_conversion;
    }

    public void setRatio_conversion(String ratio_conversion) {
        this.ratio_conversion = ratio_conversion;
    }

    public String getResultado_conversion() {
        return resultado_conversion;
    }

    public void setResultado_conversion(String resultado_conversion) {
        this.resultado_conversion = resultado_conversion;
    }
}
