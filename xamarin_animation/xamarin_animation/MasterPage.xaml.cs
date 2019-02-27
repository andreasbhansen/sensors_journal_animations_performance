using System;
using System.Collections.Generic;

using Xamarin.Forms;

namespace xamarin_animation
{
    public partial class MasterPage : ContentPage
    {
        public ListView ListView { get { return listView; } }

        public MasterPage()
        {
            InitializeComponent();

            var menuItems = new List<MenuItem>();
            menuItems.Add(new MenuItem
            {
                Title = "Animation Page",
                TargetPage = typeof(FrontPage)
            });

            menuItems.Add(new MenuItem
            {
                Title = "Second Page",
                TargetPage = typeof(SecondPage)
            });

            listView = new ListView
            {
                ItemsSource = menuItems,
                ItemTemplate = new DataTemplate(() =>
                {
                    var grid = new Grid { Padding = new Thickness(5, 10) };
                    grid.ColumnDefinitions.Add(new ColumnDefinition { Width = new GridLength(30) });
                    grid.ColumnDefinitions.Add(new ColumnDefinition { Width = GridLength.Star });

                    var label = new Label { VerticalOptions = LayoutOptions.FillAndExpand };
                    label.SetBinding(Label.TextProperty, "Title");

                    grid.Children.Add(label, 1, 0);

                    return new ViewCell { View = grid };
                }),
                SeparatorVisibility = SeparatorVisibility.None
            };


            listView.ItemsSource = menuItems;


            Content = new StackLayout
            {
                Children = { listView }
            };

        }

    }
}
