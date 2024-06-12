export class ApiError {
    estado: string = ""; // O HttpStatus si tienes un tipo definido para los estados HTTP
    code: number = 0;
    fecha: string = ""; // Puedes usar Date en lugar de string si prefieres manejarlo como un objeto de fecha
    message: string = "";
    detalle?: string; // Opcional, ya que puede estar ausente

    constructor(data: any) {
        this.estado = data.estado;
        this.code = data.code;
        this.fecha = data.fecha;
        this.message = data.message;
        this.detalle = data.detalle;
    }
}