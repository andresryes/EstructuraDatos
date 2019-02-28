using NUnit.Framework;
namespace Tarea9
{
    internal class AsignacionColaTest
    {
        [TestFixture]
        public void agregarTest()
        {
            AsignacionCola asignacionCola = new AsignacionCola();
            Trabajador trabajador = new Trabajador("", 1, 1);
            Asignacion asignacion = new Asignacion(trabajador, "");
            int lenghtI = asignacionCola.length;
            asignacionCola.agregar(asignacion);
            int lenght2 = asignacionCola.length();
            Assert.That(lenght2 == lenghtI + 1);
        }

        public void vaciarCola()
        {
            AsignacionCola asignacionCola = new AsignacionCola();
            Trabajador trabajador = new Trabajador("", 1, 1);
            Asignacion asignacion = new Asignacion(trabajador, "");
            int lenghtI = asignacionCola.length;
            asignacionCola.agregar(asignacion);
            int lenght2 = asignacionCola.length();
            asignacionCola.vaciarCola();
            Assert.That(lenght2 == 0);
        }
    }
}