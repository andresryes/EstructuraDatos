using System;

namespace Tarea9
{
    internal class TrabajadorList
    {
        private Trabajador head;

        private Trabajador tail;

        public Trabajador getTail()
        {
            return tail;
        }

        public void setTail(Trabajador tail)
        {
            this.tail = tail;
        }

        public Trabajador getHead()
        {
            return head;
        }

        public int length = 0;

        public void setHead(Trabajador head){
            this.head = head;
            this.tail = head;
            length++;
        }

        public int Length()
        {
            return length;
        }

        public void agregar(Trabajador trabajador)
        {
            bool agregado = false;
            Trabajador temp = head;
            Trabajador ant = head;

            if(trabajador.SSN < head.SSN)
            {
                trabajador.Siguiente = head;
                head = trabajador;
                agregado = true;
                length++;
            }
            else
            {
                while (temp != null)
                {
                    if (trabajador.SSN < temp.SSN)
                    {
                        trabajador.Siguiente = temp;
                        ant.Siguiente = trabajador;
                        agregado = true;
                        length++;
                        temp = null;
                    }
                    else
                    {
                        ant = temp;
                        temp = temp.Siguiente;
                    }
                }
            }

            if (!agregado)
            {
                tail.Siguiente = trabajador;
                tail = trabajador;
                length++;
            }
            
        }

        public void printList()
        {
            Trabajador temp = head;
            while(temp != null)
            {
                Console.WriteLine("Nombre: "+temp.Nombre + " - SSN: " + temp.SSN + " - Dias: "+temp.DiasTrabajados);
                temp = temp.Siguiente;
            }
        }

        public Trabajador getTrabajador(int index)
        {
            Trabajador ret = null;
            Trabajador temp = head;
            int contador = -1;
            while (contador != index)
            {
                ret = temp;
                temp = temp.Siguiente;
                contador++;
            }

            return ret;
        }

        public void actualizarList(AsignacionCola asignacion)
        {
            Asignacion temp = asignacion.getHead();
            Trabajador temp1 = head;
            while (temp != null)
            {
                temp1 = head;
                while (temp1 != null)
                {
                    if(temp1.SSN == temp.getTrabajador().SSN)
                    {
                        temp1.DiasTrabajados++;
                        temp1 = temp1.Siguiente;

                    }
                    else
                    {
                        temp1 = temp1.Siguiente;
                    }
                }
                temp = temp.Siguiente;
            }
        }
    }
}