using System;
using System.Collections.Generic;

using Xamarin.Forms;

namespace xamarin_animation
{
    public partial class SecondPage : ContentPage
    {
        public SecondPage()
        {
            InitializeComponent();

            Title = "Second Page";

            this.Appearing += (sender, e) => {
                System.Diagnostics.Debug.WriteLine(System.Diagnostics.Stopwatch.GetTimestamp());
            };
        }


    }
}
