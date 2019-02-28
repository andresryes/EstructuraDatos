using System;

namespace Tarea9
{
    internal class EntidadList
    {
        private string[] entidadList = {"entidad 1", "entidad 2", "entidad 3", "entidad 4", "entidad 5", "entidad 6", "entidad 7"};

        public int length()
        {
            return entidadList.Length;
        }

        public string getRandomEntity()
        {
            Random random = new Random();
            int index = random.Next(entidadList.Length);
            return entidadList[index];
        }

        public string getEntity(int index)
        {
            return entidadList[index];
        }
    }
}