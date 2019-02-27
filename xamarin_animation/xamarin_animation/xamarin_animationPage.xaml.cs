using Xamarin.Forms;
using Lottie.Forms;

namespace xamarin_animation
{
    public partial class xamarin_animationPage : MasterDetailPage
    {
        
        public xamarin_animationPage()
        {
            InitializeComponent();

            MasterPage masterPage = new MasterPage();
            Master = masterPage;
            Detail = new NavigationPage(new ContactsPageCS());

        }

    }
}
