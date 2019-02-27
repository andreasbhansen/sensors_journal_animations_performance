using System;
using System.Collections.Generic;
using System.Diagnostics;
using Xamarin.Forms;

namespace xamarin_animation
{
    public partial class MainPage : MasterDetailPage
    {

        MasterPage masterPageRef;

        public MainPage()
        {
            InitializeComponent();

            masterPageRef = new MasterPage();
            masterPageRef.ListView.ItemSelected += OnItemSelected;
            Master = masterPageRef;

            Detail = new NavigationPage(new FrontPage());
            Detail.ToolbarItems.Add(new ToolbarItem("Menu", "",() => {
                IsPresented = true;
            }));

        }

        async public void NavigateToSecondPage() {
            Debug.WriteLine("Navigate");
            //this.Detail = new NavigationPage(new SecondPage());
            //Detail = new SecondPage();
            var mdp = Application.Current.MainPage as MasterDetailPage;
            System.Diagnostics.Debug.WriteLine(System.Diagnostics.Stopwatch.GetTimestamp());
            await mdp.Detail.Navigation.PushAsync(new SecondPage());

        }

        void OnItemSelected(object sender, SelectedItemChangedEventArgs e)
        {
            var item = e.SelectedItem as MenuItem;
            if (item != null)
            {
                Detail = new NavigationPage((Page)Activator.CreateInstance(item.TargetPage));
                masterPageRef.ListView.SelectedItem = null;
            }
        }

    }
}
