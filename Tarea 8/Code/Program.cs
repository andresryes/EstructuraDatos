using System;
/*using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;*/
using NUnit.Framework;

namespace Tarea8
{
	class Program
	{
        public static bool firstTime = true;
        static PlayList playList = new PlayList();
        public static Song playingNow;

		static void Main(string[] args)
		{
			// The code provided will print ‘Hello World’ to the console.
			// Press Ctrl+F5 (or go to Debug > Start Without Debugging) to run your app.
			Console.WriteLine("Hello World!");
            Menu();
			// Go to http://aka.ms/dotnet-get-started-console to continue learning how to build a console app! 
		}
		public static void Menu() {

            int option = 0;

            while (option != 6)
            {
                Console.WriteLine("1. Add to Play List");
                Console.WriteLine("2. Play Now");
                Console.WriteLine("3. Play Next");
                Console.WriteLine("4. Play Previous");
                Console.WriteLine("5. List songs");
                Console.WriteLine("6. Salir");
                option = Int32.Parse(Console.ReadLine());

                switch (option)
                {
                    case 1:
                        Console.WriteLine("Ingrese el nombre de la canción: ");
                        string name = Console.ReadLine();
                        Song song = new Song();
                        song.setName(name);
                        if (firstTime)
                        {
                            firstTime = false;
                            playList.StartList(song);
                        }
                        else
                        {
                            playList.Add(song);
                        }
                        Console.WriteLine("Canción agregada con éxito!");
                        Menu();
                        break;
                    case 2:
                        playingNow = playList.PlayNow();
                        Console.WriteLine("Playing now: " + playingNow.getName());
                        Menu();
                        break;
                    case 3:
                        playingNow = playList.PlayNext(playingNow);
                        Console.WriteLine("Playing now: " + playingNow.getName());
                        Menu();
                        break;
                    case 4:
                        playingNow = playList.PlayPrevious(playingNow);
                        Console.WriteLine("Playing now: " + playingNow.getName());
                        Menu();
                        break;
                    case 5:
                        playList.ListSongs();
                        Menu();
                        break;
                }
            }
        }
    }
}
