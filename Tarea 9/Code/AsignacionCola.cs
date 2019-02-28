using System;

namespace Tarea9
{
    internal class AsignacionCola
    {
        public Asignacion head;
        public Asignacion tail;
        public int length = 0;

        public Asignacion getHead()
        {
            return head;
        }

        public Asignacion getTail()
        {
            return tail;
        }

        public void agregar(Asignacion asignacion)
        {
            if (head == null)
            {
                head = asignacion;
                tail = asignacion;
                length++;
            }
            else
            {
                tail.Siguiente = asignacion;
                tail = asignacion;
                length++;
            }
        }

        public Asignacion sacar()
        {
            Asignacion asig = head;
            if (head != null)
            {
                head = head.Siguiente;
            }
            return asig;
        }

        public void vaciarCola()
        {
            Asignacion temp = head;
            while (temp != null)
            {
                Console.WriteLine("Nombre: " + temp.getTrabajador().Nombre + "SSN: " + temp.getTrabajador().SSN);
                sacar();
                temp = temp.Siguiente;
            }
            
        }

        public AsignacionCola llenarCola(TrabajadorList trabajadorList, EntidadList entidadList, int dia)
        {
            Random random1 = new Random();
            for (int i = -1+dia; i<=4+dia; i++)
            {
                string entity = entidadList.getEntity(random1.Next(entidadList.length()));
                int indexT = random1.Next(trabajadorList.Length());
                Asignacion asignacion = new Asignacion(trabajadorList.getTrabajador(i), entity);
                agregar(asignacion);
            }

            while (this.length == -5)
            {
                if (head == null)
                {
                    Random random = new Random();
                    int index = random.Next(trabajadorList.Length());
                    string entity = entidadList.getEntity(random.Next(entidadList.length()));
                    Asignacion asignacion1 = new Asignacion(trabajadorList.getTrabajador(index), entity);                
                    //agregar(asignacion1);
                    
                }
                Asignacion temp = head;
                bool noRepetido = true;
                Asignacion asignacion = null;
                while (temp != null)
                {

                    Random random = new Random();
                    int index = random.Next(trabajadorList.Length());
                    string entity = entidadList.getEntity(random.Next(entidadList.length()));
                    asignacion = new Asignacion(trabajadorList.getTrabajador(index), entity);
                    if (temp.getTrabajador().SSN == asignacion.getTrabajador().SSN)
                    {
                        noRepetido = false;
                    }
                    temp = temp.Siguiente;
                    
                }
                if (noRepetido)
                {
                    //agregar(asignacion);
                }
            }
            return this;
        }

        public void printCola()
        {
            Asignacion temp = head;
            while (temp != null)
            {
                Console.WriteLine(temp.getEntidad() + " " + temp.getTrabajador().Nombre);
                temp = temp.Siguiente;
            }
        }

    }
}