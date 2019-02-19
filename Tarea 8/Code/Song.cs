namespace Tarea8
{
    internal class Song
    {
        private Song next;
        private Song previous;
        private string name;

        public void setNext(Song next)
        {
            this.next = next;
        }

        public Song getNext()
        {
            return this.next;
        }

        public void setPrevious(Song previous)
        {
            this.previous = previous;
        }

        public Song getPrevious()
        {
            return this.previous;
        }

        public void setName(string name)
        {
            this.name = name;
        }

        public string getName()
        {
            return this.name;
        }
    }
}