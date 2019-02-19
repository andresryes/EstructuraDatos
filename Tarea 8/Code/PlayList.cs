using System;

namespace Tarea8
{
	public class PlayList
	{
        private Song head;
        private Song tail;
        private int lenght = 0;

        public PlayList()
        {

        }

        internal Song getHead()
        {
            return this.head;
        }

        internal Song getTail()
        {
            return this.tail;
        }

        public int getLength()
        {
            return this.lenght;
        }

        internal void StartList(Song head)
        {
            this.head = head;
            this.tail = head;
            lenght++;
        }

        internal void Add(Song song)
        {
            this.tail.setNext(song);
            song.setPrevious(this.tail);
            this.tail = song;
            lenght++;
        }

        internal Song PlayNow()
        {
            Random random = new Random();
            int position = random.Next(0, lenght);
            Song temp = head;
            int counter=0;
            Console.WriteLine(position);
            while(counter < position)
            {
                counter++;
                if (temp.getNext() != null)
                {
                    temp = temp.getNext();
                }
            }
            return temp;
        }

        internal Song PlayNext(Song song)
        {
            if (song != tail)
            {
                return song.getNext();
            }
            else
            {
                Console.WriteLine("Ha llegado al final de la lista");
                return song;
            }
        }

        internal Song PlayPrevious(Song song)
        {
            if(song != head)
            {
                return song.getPrevious();
            }
            else
            {
                Console.WriteLine("Ha llegado al final de la lista");
                return song;
            }
        }

        internal void ListSongs()
        {
            Song temp = head;
            int counter = 0;
            while (counter < lenght)
            {
                counter++;
                Console.WriteLine(counter + ". " + temp.getName());
                if (temp.getNext() != null)
                {
                    temp = temp.getNext();
                }

            }
        }
	}
}