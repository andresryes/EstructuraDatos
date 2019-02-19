using NUnit.Framework;
using System;

namespace Tarea8
{
    [TestFixture]
    internal class PlayListTest
    {
        public static PlayList playList = new PlayList();

        public PlayListTest()
        {

        }

        [Test]
        public void StartListTest()
        {
            Song songTest = new Song();
            int lengthInicial = playList.getLength();
            playList.StartList(songTest);
            int lengthFinal = playList.getLength();
            Assert.That(lengthFinal > lengthInicial);
        }

        [Test]
        public void AddTest()
        {
            Song songTest = new Song();
            int lengthInicial = playList.getLength();
            playList.StartList(songTest);
            playList.Add(songTest);
            int lengthFinal = playList.getLength();
            Console.WriteLine(lengthInicial);
            Console.WriteLine(lengthFinal);
            Assert.That(lengthFinal > lengthInicial);
        }

        [Test]
        public void PlayPreviousTest() //Test if it tries to get before the head
        {
            Song previous = playList.PlayPrevious(playList.getHead());
            Assert.That(previous == playList.getHead());
        }

        [Test]
        public void PlayNextTest() //Test if it tries to get before the head
        {
            Song next = playList.PlayPrevious(playList.getTail());
            Assert.That(next == playList.getTail());
        }
    }
}