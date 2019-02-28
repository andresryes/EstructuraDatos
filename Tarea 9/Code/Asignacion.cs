namespace Tarea9
{
    internal class Asignacion
    {
        private Trabajador trabajador;
        private string entidad;
        public Asignacion Siguiente;

        public Asignacion(Trabajador trabajador, string entidad)
        {
            this.trabajador = trabajador;
            this.entidad = entidad;
        }

        public Trabajador getTrabajador()
        {
            return trabajador;
        }

        public string getEntidad()
        {
            return entidad;
        }
    }
}