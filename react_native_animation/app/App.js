import React from 'react';

import { Navigation } from 'react-native-navigation';
import FrontPage from './frontpage';
import SecondPage from './secondpage';
import Drawer from './Drawer';

const registerScreens = () => {
  Navigation.registerComponent('FrontPage', () => FrontPage),
  Navigation.registerComponent('SecondPage', () => SecondPage),
  Navigation.registerComponent('Drawer', () => Drawer)
}

registerScreens();

Navigation.startSingleScreenApp({
  screen: {
    screen: 'FrontPage',
    title: 'Animation Page',
    navigatorStyle: {},
    navigatorButtons: {
      leftButtons: [
        {
          id: 'sideMenu'
        },
      ],
    }
  },
  drawer: {
    left: {
      screen: 'Drawer'
    }
  }
});