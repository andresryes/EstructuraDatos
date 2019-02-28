
using System;
using System.Collections.Generic;
using System.Linq;

using System.Text;
using System.Threading.Tasks;

namespace Tarea9
{
    class Program
    {
        public static EntidadList entidadList = new EntidadList();
        public static TrabajadorList trabajadorList = new TrabajadorList();
        public static AsignacionCola asignacionCola = new AsignacionCola();

        static void Main(string[] args)
        {
            // The code provided will print ‘Hello World’ to the console.
            // Press Ctrl+F5 (or go to Debug > Start Without Debugging) to run your app.
            Console.WriteLine("Hello World!");
            Console.WriteLine("Iniciando Programa");
            InicializarPrograma();
            Console.WriteLine("Llenando la Cola...");
            asignacionCola = asignacionCola.llenarCola(trabajadorList, entidadList, 2);
            Console.WriteLine("Mostrar Cola");
            asignacionCola.printCola();
            Console.WriteLine("Actualizando List Trabajadores");
            trabajadorList.actualizarList(asignacionCola);
            Console.WriteLine("Lista Actualizada");
            trabajadorList.printList();
            Console.WriteLine("Vaciar Cola");
            asignacionCola.vaciarCola();
            Console.ReadKey();
            // Go to http://aka.ms/dotnet-get-started-console to continue learning how to build a console app! 
        }


        public static void InicializarPrograma()
        {
            Trabajador t1 = new Trabajador("Andres", 1, 0);
            Trabajador t2 = new Trabajador("Juan", 2, 0);
            Trabajador t3 = new Trabajador("Marcos", 3, 0);
            Trabajador t4 = new Trabajador("Pedro", 4, 0);
            Trabajador t5 = new Trabajador("Carlos", 5, 0);
            Trabajador t6 = new Trabajador("Daniel", 6, 0);
            Trabajador t7 = new Trabajador("Joviel", 7, 0);
            Trabajador t8 = new Trabajador("Abner", 8, 0);


            trabajadorList.setHead(t3);
            trabajadorList.agregar(t1);
            trabajadorList.agregar(t2);
            trabajadorList.agregar(t5);
            trabajadorList.agregar(t6);
            trabajadorList.agregar(t7);
            trabajadorList.agregar(t8);

            //trabajadorList.printList();

            trabajadorList.agregar(t4);
            //trabajadorList.agregar(t1);
            trabajadorList.printList();
            //Console.WriteLine(trabajadorList.Length());

            //Console.WriteLine(trabajadorList.getHead().SSN + " " + trabajadorList.getTail().SSN);
        }
    }
}
