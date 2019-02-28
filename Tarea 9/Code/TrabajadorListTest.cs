using NUnit.Framework;
namespace Tarea9
{
    internal class TrabajadorListTest
    {
        [TextFixture]
        TrabajadorList trabajadorList = new TrabajadorList();

        [Test]
        public void testAgregar()
        {
            Trabajador t = new Trabajador("", 1, 2);
            int init =trabajadorList.Length();
            trabajadorList.agregar(t);

            int dos = trabajadorList.length;

            Assert.That(init < dos);
        }
    }
}