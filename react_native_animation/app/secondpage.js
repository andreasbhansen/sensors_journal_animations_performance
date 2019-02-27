import React from 'react';
import { Text, View, StyleSheet } from 'react-native';

export default class SecondPage extends React.Component {

  componentDidMount() {
    console.log('afterNavigate', performance.now());
  }

  render() {
    return (
      <View style={styles.container}>
        <Text>Welcome to Second Page</Text>
      </View>
    );
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center'
  }
});
