import React from 'react';
import { StyleSheet, View, Button, TouchableOpacity, Text } from 'react-native';

export default class Drawer extends React.Component {

    toggleDrawer() {
        this.props.navigator.toggleDrawer({
            side: 'left'
        });
    }

    navigateToPage(screen, title) {
        this.props.navigator.resetTo({
            screen,
            title,
            leftButtons: [
                {
                  id: 'sideMenu'
                },
              ],
        });
        this.toggleDrawer();
    }

    render() {
        return (
            <View style={styles.container}>
                <TouchableOpacity onPress={this.navigateToPage.bind(this, 'FrontPage', 'Animation Page')}>
                    <Text style={styles.menuItem}>Animation Page</Text>
                </TouchableOpacity>

                <TouchableOpacity onPress={this.navigateToPage.bind(this, 'SecondPage', 'Second Page')}>
                    <Text style={styles.menuItem}>Second Page</Text>
                </TouchableOpacity>
            </View>
        );
    }
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        width: 300,
        flexDirection: 'column',
        alignItems: 'center',
        paddingTop: 100,
        backgroundColor: '#ffffff',
    },
    menuItem: {
        fontWeight: 'bold',
        marginTop: 40,
        height: 30,
        backgroundColor: '#ffffff'
    }
});