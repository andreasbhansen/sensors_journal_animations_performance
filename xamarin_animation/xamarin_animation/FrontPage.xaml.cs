using System;
using System.Collections.Generic;
using System.Diagnostics;
using Lottie.Forms;
using Xamarin.Forms;

namespace xamarin_animation
{
    public partial class FrontPage : ContentPage
    {
        AnimationView animationView;

        public FrontPage()
        {
            InitializeComponent();



            var stackLayout = new StackLayout();

            animationView = new AnimationView
            {
                Animation = "favourite_app_icon.json",
                AutoPlay = false,
                Loop = false,
                VerticalOptions = LayoutOptions.FillAndExpand,
                HorizontalOptions = LayoutOptions.FillAndExpand
            };

            Button playButton = new Button
            {
                Text = "Play Animation",
                VerticalOptions = LayoutOptions.Center,
                HorizontalOptions = LayoutOptions.Center
            };

            playButton.Clicked += (sender, e) => {
                Debug.WriteLine("Button clicked");
                animationView.Play();
            };

            Button navigationButton = new Button
            {
                Text = "Navigate to Second Page",
                VerticalOptions = LayoutOptions.Center,
                HorizontalOptions = LayoutOptions.Center
            };

            navigationButton.Clicked += (sender, e) => {

                MainPage mainPageRef = new MainPage();

                mainPageRef.NavigateToSecondPage();

            };


            stackLayout.Children.Add(animationView);
            stackLayout.Children.Add(playButton);
            stackLayout.Children.Add(navigationButton);

            Title = "Animation Page";
            Content = stackLayout;
        }
    }
}
