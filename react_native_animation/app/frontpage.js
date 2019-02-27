import React from 'react';
import { TouchableHighlight, Text, View, StyleSheet, Button } from 'react-native';
import Animation from 'lottie-react-native';
import { setTimeout } from 'core-js/library/web/timers';

export default class FrontPage extends React.Component {

  constructor(props) {
    super(props);
    this.state = {
      hidden: true
    };
  }

  playAnimation() {
    this.setState({
      hidden: false
    }, () => {
      this.animation.play();
    });
  }

  navigateToSecondPage() {
    console.log('onNavigate', performance.now());
    this.props.navigator.push({
      screen: 'SecondPage',
      title: 'Second Page'
    });
  }

  renderAnimationView() {
    return (
      <Animation
        ref={animation => { this.animation = animation; }}
        style={{
          width: 300,
          height: 300,
        }}
        source={require('./favourite_app_icon.json')}
      />
    );
  }

  render() {
    return (
      <View style={styles.container}>

        {this.state.hidden ? <View style={{width: 300, height: 300}}></View> : <Animation
          ref={animation => { this.animation = animation; }}
          style={{
            alignSelf: 'center',
            width: 300,
            height: 300,
          }}
          source={require('./favourite_app_icon.json')}
        />}

        <Button
          onPress={this.playAnimation.bind(this)}
          title="Play Animation"
          color="#841584"
        />
        <View style={styles.spacer}></View>
        <Button
          onPress={this.navigateToSecondPage.bind(this)}
          title="Navigate to Second Page"
          color="#841584"
        />
      </View>
    );
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    flexDirection: 'column',
    
    alignItems: 'center'
  },
  spacer: {
    margin: 10
  }
});
