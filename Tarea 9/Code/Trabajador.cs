namespace Tarea9
{
    internal class Trabajador
    {
        public Trabajador(string Nombre, int SSN, int DiasTrabajados)
        {
            this.Nombre = Nombre;
            this.SSN = SSN;
            this.DiasTrabajados = DiasTrabajados;
        }

        public string Nombre { get; set; }

        public int SSN { get; set; }

        public int DiasTrabajados { get; set; }

        public Trabajador Siguiente { get; set; }
    }
}