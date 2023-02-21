using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Shapes;

namespace Proyecto_Moises_VictorB.paginas
{
    /// <summary>
    /// Lógica de interacción para Window1.xaml
    /// </summary>
    public partial class Window1 : Window
    {
        public Window1()
        {
            InitializeComponent();
        }
        private void MyCommands_CanExecute(object sender, CanExecuteRoutedEventArgs e)
        {
            e.CanExecute = true;
        }
        private void NewCommand_Executed(object sender, ExecutedRoutedEventArgs e)
        {
            // El contenido central se cambia con la nueva pantalla
            myFrame.Navigate(new juego1play());
        }
        private void CloseCommand_Executed(object sender, ExecutedRoutedEventArgs e)
        {
            // Volvemos hacia atrás hasta llegar al contenido inicial y resetear la página central
            /*while (myFrame.CanGoBack)
            {
                myFrame.GoBack();
            }*/
            // Otra opción es dejar el Frame a null
            myFrame.Content= null;
        }
    }
}
