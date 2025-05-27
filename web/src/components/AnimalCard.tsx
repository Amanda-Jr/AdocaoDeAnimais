import { Mars, Venus } from "lucide-react";

export type Animal = {
    id: number;
    animal: "dogs" | "cats";
    size: "small" | "medium" | "large";
    age: "puppy" | "adult";
    location: string;
    name: string;
    image: string;
};

export function AnimalCard({
                               animal,
                               size,
                               age,
                               location,
                               name,
                               image,
                           }: Animal) {
    const displaySize: Record<string, string> = {
        small: "Pequeno",
        medium: "Médio",
        large: "Grande",
    };

    const displayAge: Record<string, string> = {
        puppy: "Filhote",
        adult: "Adulto",
    };

    const icon =
        animal === "dogs" ? (
            <Mars className="text-[#299EF3] inline" />
        ) : (
            <Venus className="text-[#FF56EE] inline" />
        );

    return (
        <div
            className="text-center text-black bg-[#F2F2F2] max-w-min max-h-min rounded-2xl overflow-hidden hover:scale-105 transition-transform duration-500">
            <img
                src={image}
                alt={`Imagem de ${name}`}
                onError={(e) => {
                    e.currentTarget.src = "/fallback-image.png";
                }}
                className="cursor-pointer"
            />
            <div className="py-3 px-7 text-[0.9rem]">
                <p className="font-extrabold whitespace-nowrap text-[1.2rem]">
                    {name} {icon}
                </p>
                <p className="whitespace-nowrap">
                    {displaySize[size]} <span>●</span> {displayAge[age]}
                </p>
                <p>{location}</p>
            </div>
        </div>
    );
}
