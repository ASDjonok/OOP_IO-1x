package io12._14_Iliov.Lab4;

public class Port {
    Ship [] fleet;
    public Port(int n) {
        this.fleet = create_fleet(n);
    }

    public static Ship [] create_fleet(int n)
    {
        Ship [] arr_ships = new Ship[n];
        for(int i = 0; i<n; i++)
        {
            Ship ship = new Ship();
            arr_ships[i] = ship;
        }
        return arr_ships;
    }

    public void print_fleet(Ship [] arr_ships,int n)
    {
        for(int i = 0; i<n; i++)
        {
            System.out.print("Objekt №"+ i +": ");
            System.out.print("name - " + arr_ships[i].name + ", ");
            System.out.print("speed - " + arr_ships[i].speed + ", ");
            System.out.print("lenght - " + arr_ships[i].lenght + ", ");
            System.out.print("carrying capacity - " + arr_ships[i].carrying_capacity + ", ");
            System.out.println("age - " + arr_ships[i].age + ".");
        }
    }

    public void fromBtoS_speed (Ship [] arr_ships)
    {
        for(int i=1; i < arr_ships.length; i++)
        {
            for(int k=i; k>0 &&  arr_ships[k].speed > arr_ships[k-1].speed; k--)
            {
                Ship tmp = arr_ships[k-1];
                arr_ships[k-1] = arr_ships[k];
                arr_ships[k] = tmp;
            }
        }
    }

    public void fromStoB_age (Ship [] arr_ships)
    {
        for(int i=1;i < arr_ships.length; i++)
        {
            for(int k=i; k>0 &&  arr_ships[k-1].age > arr_ships[k].age; k--)
            {
                Ship tmp = arr_ships[k-1];
                arr_ships[k-1] = arr_ships[k];
                arr_ships[k] = tmp;
            }
        }
    }
}
